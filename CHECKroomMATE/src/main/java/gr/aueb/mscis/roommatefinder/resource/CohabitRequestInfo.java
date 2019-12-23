package main.java.gr.aueb.mscis.roommatefinder.resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import main.java.gr.aueb.mscis.roommatefinder.model.CohabitRequest;
import main.java.gr.aueb.mscis.roommatefinder.model.Flatmate;
import main.java.gr.aueb.mscis.roommatefinder.model.HouseAd;
import main.java.gr.aueb.mscis.roommatefinder.model.RequestState;

public class CohabitRequestInfo {
	
	
	 private long id;
	 private long flatmateId;
	 private RequestState state = RequestState.NEW;
	 private boolean connection;
	 private Date dateOfRequest;
	 
	 public CohabitRequestInfo(long flatmateId,boolean connection, Date dateOfRequest,long id) {
		this(flatmateId,connection,dateOfRequest);
		this.id = id;
	}
	 
	 public CohabitRequestInfo(long flatmateId,boolean connection, Date dateOfRequest) {
		 
		super();
		this.flatmateId = flatmateId;
		this.connection = connection;
		this.dateOfRequest = dateOfRequest;
		
	 }
	 
	 public CohabitRequestInfo(CohabitRequest request) {
		 
		 id = request.getId();
		 connection = request.isConnection();
		 state = request.getState();
		 dateOfRequest = request.getDateOfRequest();
		 flatmateId = request.getFlatmate().getId();
		 
	 }
	 
	 
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isConnection() {
		return connection;
	}

	public void setConnection(boolean connection) {
		this.connection = connection;
	}

	public Date getDateOfRequest() {
		return dateOfRequest;
	}

	public void setDateOfRequest(Date dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
	}

	public long getFlatmateId() {
		return flatmateId;
	}

	public void setFlatmateId(long flatmateId) {
		this.flatmateId = flatmateId;
	}
	 
	public static CohabitRequestInfo wrap(CohabitRequest request) {
		return new CohabitRequestInfo(request);
	}
	
	public static List<CohabitRequestInfo> wrap(List<CohabitRequest> requests){
		
		List<CohabitRequestInfo> CohabitRequestInfoList = new ArrayList<>();
		
		for(CohabitRequest request : requests) {
			CohabitRequestInfoList.add(new CohabitRequestInfo(request));
		}
		
		return CohabitRequestInfoList;
		
	}
	
	
	public CohabitRequest getCohabitRequest(EntityManager em) {
		CohabitRequest request = null;
		
		if(id <= -1) {
			request = em.find(CohabitRequest.class,id);
		}else {
			request = new CohabitRequest();
		}
		
		request.setConnection(connection);
		request.setDateOfRequest(dateOfRequest);
		request.setState(state);
		
		Flatmate flatmate = em.getReference(Flatmate.class, flatmateId);
		request.setFlatmate(flatmate);
		
		return request;
		
	}
	
	
	 
	 

}
