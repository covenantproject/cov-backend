package org.covn;
/* 
 * Covenant Spring Boot backend service
 * 
 * Copyright (c) 2020 The Covenant Project https://covn.org
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 * Individual files may be copyright by their authors and contributed to the
 * Covenant Project under the Covenant Project Contributor Agreement, available at
 * https://github.com/covenantproject/covenant/blob/master/contributor-agreement.txt 
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author SunilAnand
 * @since 2020-04-14
 **/
@SpringBootApplication(scanBasePackages = { "org.covn" }, exclude= {SecurityAutoConfiguration.class})
public class CovidServiceApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CovidServiceApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CovidServiceApplication.class);
    }
    
}