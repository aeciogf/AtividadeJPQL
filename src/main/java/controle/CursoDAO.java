package controle;

import javax.persistence.EntityManager;

import modelo.Curso;

public class CursoDAO {
	public static void inserirCurso(Curso c){
		EntityManager em = Conexao.getInstance();
		em.getTransaction().begin();
		em.persist(c);
		System.out.println("Curso " + c.getNome() + " cadastrado.");
		em.getTransaction().commit();
	}
	
	public static void alterarCurso(Curso c){
		EntityManager em = Conexao.getInstance();
		Curso c2 = em.find(Curso.class, 1);
		
		em.getTransaction().begin();
		em.merge(c2);
		System.out.println("Curso " + c2.getNome() + " alterado.");
		em.getTransaction().commit();
	}

	public static void deletarCurso(Curso c){
		EntityManager em = Conexao.getInstance();
		
		em.getTransaction().begin();
		em.remove(c);
		System.out.println("Curso " + c.getNome() + " deletado.");
		em.getTransaction().commit();
	}
}
