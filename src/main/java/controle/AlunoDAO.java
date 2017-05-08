package controle;

import javax.persistence.EntityManager;

import modelo.Aluno;

public class AlunoDAO {
	public static void inserirAluno(Aluno a){
		EntityManager em = Conexao.getInstance();
		em.getTransaction().begin();
		em.persist(a);
		System.out.println("Aluno " + a.getNome() + " cadastrado.");
		em.getTransaction().commit();
	}
	
	public static void alterarAluno(Aluno a){
		EntityManager em = Conexao.getInstance();
		Aluno a2 = em.find(Aluno.class, 1);
		
		em.getTransaction().begin();
		em.merge(a2);
		System.out.println("Aluno " + a2.getNome() + " alterado.");
		em.getTransaction().commit();
	}

	public static void deletarAluno(Aluno a){
		EntityManager em = Conexao.getInstance();
		
		em.getTransaction().begin();
		em.remove(a);
		System.out.println("Aluno " + a.getNome() + " deletado.");
		em.getTransaction().commit();
	}

}
