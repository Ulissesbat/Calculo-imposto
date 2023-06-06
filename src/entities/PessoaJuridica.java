package entities;

public class PessoaJuridica extends Contribuintes {
	private Integer numerosFuncionarios; 
	
	public PessoaJuridica() {
		super();
	}


	public PessoaJuridica(String nome, double rendaAnual, int numerosFuncionarios) {
		super(nome, rendaAnual);
		this.numerosFuncionarios = numerosFuncionarios;
	}


	public int getNumerosFuncionarios() {
		return numerosFuncionarios;
	}

	public void setNumerosFuncionarios(int numerosFuncionarios) {
		this.numerosFuncionarios = numerosFuncionarios;
	}
	@Override
	public double imposto() {
        
        if (numerosFuncionarios <= 10) {
        	return getRendaAnual() * 0.16;
        } 
        else {
        	return getRendaAnual() * 0.14;
        }
        
	}
}
