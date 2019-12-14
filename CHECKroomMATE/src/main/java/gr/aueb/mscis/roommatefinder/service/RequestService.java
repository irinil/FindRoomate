package main.java.gr.aueb.mscis.roommatefinder.service;

import java.util.List;

import javax.persistence.EntityManager;
import main.java.gr.aueb.mscis.roommatefinder.model.CohabitRequest;
import main.java.gr.aueb.mscis.roommatefinder.model.Flatmate;
import main.java.gr.aueb.mscis.roommatefinder.model.House;
import main.java.gr.aueb.mscis.roommatefinder.model.HouseAd;
import main.java.gr.aueb.mscis.roommatefinder.model.RequestState;

//In this service, we follow our Use case schema, in which flatmate sends the request. So, the service will involve flatmate only!

public class RequestService {
	
	
	private EntityManager em;

	public RequestService(EntityManager em) {
		this.em = em;
	}
	
	public boolean createRequest(long houseAd_id,long flatmateId) {
		Flatmate flatmate = findFlatmateById(flatmateId);

		HouseAd houseAd = em.find(HouseAd.class, houseAd_id);
		if(houseAd != null) {
			CohabitRequest cohabitRequest = flatmate.request(houseAd);
			em.persist(cohabitRequest);	
			return true;
		}else return false;
	}
	
	public boolean cancelRequest(long requestId) {
		CohabitRequest request = findCohabitRequestById(requestId);
		if(request!=null) {
			request.setState(RequestState.CANCELED);
			em.remove(request);
			return true;
		}
		return false;
	}
	
	public Flatmate findFlatmateById(long id) {

		return em.find(Flatmate.class, id);
	}
	
	
	public CohabitRequest findCohabitRequestById(long id) {
		return em.find(CohabitRequest.class, id);
	}
	
	public List<HouseAd> findAllHouseAds() {
		List<HouseAd> results = null;

		results = em.createQuery("select houseAd from HouseAd houseAd" , HouseAd.class)
				.getResultList();

		return results;
	}
	
	public List<House> findAllHouseAdsWithHouse(long residentId) {
		List<House> results = null;

		results = em.createQuery("select houseAd.resident.house from HouseAd houseAd where houseAd.resident.id = :residentId" , House.class)
				.setParameter("residentId", residentId)
				.getResultList();

		return results;
	}
	

}
