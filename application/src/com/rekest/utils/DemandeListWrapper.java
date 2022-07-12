package com.rekest.utils;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.rekest.entities.Demande;


@XmlRootElement(name = "demandes")
public class DemandeListWrapper {
	
	private List<Demande> demandes;

	@XmlElement(name = "demande")
	public List<Demande> getDemandes() {
		return demandes;
	}

	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}	
	
}