package org.oweis.Lear_API.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.oweis.Lear_API.model.Splice;
import org.oweis.Lear_API.model.Wire;

public class SpliceService {
	
	Splice splice;
	ArrayList<Splice> splices;	
	Session session;
	Criteria criteria;
	
	public SpliceService(){
		if(!ConnexionService.open){
		ConnexionService.openConnexion();
		}
		this.session = ConnexionService.session;
	}		

	public ArrayList<Splice> getAllSplice(){
		splices =  new ArrayList<>();
	
		criteria = session.createCriteria(Splice.class);
		splices = (ArrayList<Splice>) criteria.list();
		return splices;
	}
	
	public ArrayList<Splice> getAllSpliceByIdFamily(int idFamily){
		
		criteria = session.createCriteria(Splice.class).add(Restrictions.eq("idFamily",idFamily));
		splices =  (ArrayList<Splice>) criteria.list();
		  session.flush();
	        session.clear();

		return splices;
	}
	
	
	public Splice getSplice(int id){
		
		splice = (Splice) session.get(Splice.class, id);
		  session.flush();
	        session.clear();
	
		return splice;
	}
	
	public Splice getSpliceByNameSplice(int idFamily,String nameSplice){
		
		
		criteria = session.createCriteria(Splice.class).
				add(Restrictions.eq("idFamily",idFamily)).
				add(Restrictions.eq("nameSplice",nameSplice));
		splice = (Splice) criteria.uniqueResult();
		  session.flush();
	        session.clear();
	
		return splice;
	}
	
	public Splice addSplice(Splice splice){
	

		session.save(splice);
		  session.flush();
	        session.clear();
		
		
		return splice;
	}
	
	public Splice updateSplice(Splice splice){
		

		session.update(splice);
		  session.flush();
	        session.clear();
	
		return splice;
}
	
	public ArrayList<Splice> removeAllSplices(){
		
		
		criteria = session.createCriteria(Splice.class);
		splices = (ArrayList<Splice>) criteria.list();
		for(Splice splice : splices){ session.delete(splice);
		  session.flush();
	        session.clear();
		}
		return splices;
	}
	
	public ArrayList<Splice> removeAllSplicesByIdFamily(int idFamily){
		
		
		
		criteria = session.createCriteria(Splice.class).add(Restrictions.eqOrIsNull("idFamily",idFamily));
		splices = (ArrayList<Splice>) criteria.list();
		for(Splice splice : splices) {session.delete(splice);
		  session.flush();
	        session.clear();}
		
		return splices;
	}
	
	public Splice removeSplice(Splice splice){
		

		session.delete(splice);
		  session.flush();
	        session.clear();
	
		return splice;
}
	
	public Splice removeSplice(int id){
	

		splice = (Splice) session.get(Splice.class,id);
		session.delete(splice);
		  session.flush();
	        session.clear();

		return splice;
	}
	
	public Splice removeSplice(int idFamily,String nameSplice){
		
		
		
		criteria = session.createCriteria(Splice.class).add(Restrictions.eq("idFamily",idFamily)).add(Restrictions.eq("nameSplice",nameSplice));
		splice = (Splice) criteria.uniqueResult();
		
		session.delete(splice);
		  session.flush();
	        session.clear();
	
		return splice;
	}


	//	Functions Serve the same purpose
	//	<Section : find splices used in a partnumber> 
	public ArrayList<Splice> getAllSplicesByIdCable(int idFamily,int idCable){
		ArrayList<Splice> splices = new ArrayList<Splice>();
		Splice splice = new Splice();
		List<String> nameSplices = getAllNameSplicesByIdCable(idCable);
		for(String nameSplice : nameSplices) {
			splice = this.getSpliceByNameSplice(idFamily, nameSplice);
			splices.add(splice);
		}
		return splices;
		
	}
	public List<String> getAllNameSplicesByIdCable(int idCable){
		WireService wireService = new WireService();
		//if namesplice in wire with idPartNumber=x then splice used in partnumber with id=x
		ArrayList<Wire> wires = wireService.getAllWiresByIdCable(idCable);
		//get wires ids, to make it easy to find nameSplice
		List<Integer> listIdWires = new ArrayList<>();
	
		for(Wire wire : wires) {
			listIdWires.add(wire.getId());
		}
		//get all nameSplices
		List<String> nameSplicesFromAllWires = new ArrayList<>();
		
		for(int idWire : listIdWires){
			ArrayList<String> nameSplicesFromWire = getNameSplicesByIdWire(idWire);
				for(String nameSplice : nameSplicesFromWire){
					checkExistThenAdd(nameSplicesFromAllWires, nameSplice);
				}
			}
			return nameSplicesFromAllWires;
	}
	
		public ArrayList<String>  getNameSplicesByIdWire(int idWire){
			ArrayList<String> nameConnectors = new ArrayList<String>();
			WireService wireService = new WireService();
			Wire wire =  wireService.getWire(idWire);
			nameConnectors.add(wire.getSplice_A());
			nameConnectors.add(wire.getSplice_B());
			return nameConnectors;
		}
		
		public void checkExistThenAdd(List<String> nameSplices,String newName){
			if (!newName.equals("") & !nameSplices.contains(newName))
				nameSplices.add(newName);
		}
	//	</Section : find splices used in a partnumber> 

	
}

