package App.model;

import java.sql.Date;



public class Operation {

	int numeroCompte;
	String motifOperation;
	int numeroOperation;
	double debitOperation;
	double creditOperation;
	double montantOperation;
	Date date;
	int idType;
	int idMode;
	
	public int getNumeroCompte() {
		return numeroCompte;
	}
	public void setNumeroCompte(int numeroCompte) {
		this.numeroCompte = numeroCompte;
	}
	public String getMotifOperation() {
		return motifOperation;
	}
	public void setMotifOperation(String motifOperation) {
		this.motifOperation = motifOperation;
	}
	public double getDebitOperation() {
		return debitOperation;
	}
	public void setDebitOperation(double debitOperation) {
		this.debitOperation = debitOperation;
	}
	public double getCreditOperation() {
		return creditOperation;
	}
	public void setCreditOperation(double creditOperation) {
		this.creditOperation = creditOperation;
	}
	public double getMontantOperation() {
		return montantOperation;
	}
	public void setMontantOperation(double montantOperation) {
		this.montantOperation = montantOperation;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
	public int getIdType() {
		return idType;
	}
	public void setIdType(int idType) {
		this.idType = idType;
	}
	public int getIdMode() {
		return idMode;
	}
	public void setIdMode(int idMode) {
		this.idMode = idMode;
	}
	
	
	
//---------- Constructeur pour afficher le détail des opéations - Onglet "Opérations" ----------
	public Operation(int numeroCompte, String motifOperation, double debitOperation, double creditOperation, Date date) {
		super();
		this.numeroCompte = numeroCompte;
		this.motifOperation = motifOperation;
		this.debitOperation = debitOperation;
		this.creditOperation = creditOperation;
		this.date = date;
	}
	
//-----------------------------------------------------------------------------------------------
	
	public Operation(int debitOperation, double montantOperation, Date date, int numeroCompte, int idType, int idMode) {
		super();
		this.debitOperation = debitOperation;
		this.montantOperation = montantOperation;
		this.date = date;
		this.numeroCompte = numeroCompte;
		this.idType = idType;
		this.idMode = idMode;
	}
	public Operation(int numeroCompte, int numeroOperation, double debitOperation, double creditOperation, double montantOperation, Date date,
			int idType) {
		super();
		this.numeroCompte = numeroCompte;
		this.debitOperation = debitOperation;
		this.creditOperation = creditOperation;
		this.montantOperation = montantOperation;
		this.date = date;
		this.idType = idType;
	}
	public Operation(int numeroCompte, int debitOperation, int creditOperation, double montantOperation, Date date) {
		super();
		this.numeroCompte = numeroCompte;
		this.debitOperation = debitOperation;
		this.creditOperation = creditOperation;
		this.montantOperation = montantOperation;
		this.date = date;
	}
	public Operation() {
		super();
	}
	
	
	
}
