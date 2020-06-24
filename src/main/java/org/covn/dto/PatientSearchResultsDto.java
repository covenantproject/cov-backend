package org.covn.dto;

import java.util.ArrayList;
import java.util.List;

/** Patient Search Results - used in dashboards
 * 
 * @author Senthil N
 *
 */
public class PatientSearchResultsDto {
	
	private long total;
	private long size;
	private long from;
	private List<PatientDto> patients=new ArrayList<PatientDto>();
	
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public long getFrom() {
		return from;
	}
	public void setFrom(long from) {
		this.from = from;
	}
	public List<PatientDto> getPatients() {
		return patients;
	}
	public void setPatients(List<PatientDto> patients) {
		this.patients = patients;
	}
}

