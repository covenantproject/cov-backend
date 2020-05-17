package com.covid.util;

import static com.covid.util.CovidUtils.cast;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.springframework.stereotype.Component;

@Component
public class UserFilter implements Filter {
	private static final Logger log = LogManager.getLogger();
	
	public static final String PARAM_PHONE_INFO = "phoneInfo";
	public static final String PARAM_PHONE_NUM = "phoneNum";
	public static final String ATTR_PRINCIPLE_USER_ID = "principleUserId";
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		try {
			HttpServletRequest req = cast(request);
			
			Long userId = getDashboardUserId(cast(request));
			if(userId == null) {
				userId = getPhoneUserId(cast(request));
			}
			req.getSession().setAttribute(ATTR_PRINCIPLE_USER_ID, userId);
		}catch(IllegalAccessException ex) {
			throw new RuntimeException(ex);
		}

		chain.doFilter(request, response);
		
		
	}
	
	private long getPhoneUserId(HttpServletRequest req)throws IllegalAccessException{
		String encrypted = req.getParameter(PARAM_PHONE_INFO);
		String phoneNum = req.getParameter(PARAM_PHONE_NUM);
		try {
			Pair<Long, String> info = EncryptUtil.decryptUserPhoneNum(encrypted);
			long userId = info.getKey();
			String ePhoneNum = info.getValue();
			
			if(phoneNum.equals(ePhoneNum)) {
				return userId;
			}else {
				throw new RuntimeException("unmatch phoneNum "+ePhoneNum+ " = "+phoneNum);
			}

		}catch(Exception ex) {
			log.fatal("unabled to decrypt phoneInfo {}", encrypted, ex);
			throw new IllegalAccessException();
		}
	}
	
	
	private Long getDashboardUserId(HttpServletRequest req) {
		Long userId = null;
		KeycloakPrincipal<KeycloakSecurityContext> kp = cast(req.getUserPrincipal());
		if(kp != null) {
			String user = kp.getKeycloakSecurityContext().getIdToken().getPreferredUsername();
			userId = Long.parseLong(user);
		}
		
		return userId;
		
	}

}
