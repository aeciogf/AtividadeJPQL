package controle;

import javax.persistence.EntityManager;

import modelo.Curso;
import modelo.Turma;

public class TurmaDAO {
	public static void inserirTurma(Turma t){
		EntityManager em = Conexao.getInstance();
		em.getTransaction().begin();
		em.persist(t);
		System.out.println("Turma " + t.getId() + " cadastrada.");
		em.getTransaction().commit();
	}
	
	public static void alterarTurma(Turma t){
		EntityManager em = Conexao.getInstance();
		Curso t2 = em.find(Curso.class, 1);
		
		em.getTransaction().begin();
		em.merge(t2);
		System.out.println("Turma " + t2.getId() + " alterada.");
		em.getTransaction().commit();
	}

	public static void deletarTurma(Turma t){
		EntityManager em = Conexao.getInstance();
		
		em.getTransaction().begin();
		em.remove(t);
		System.out.println("Turma " + t.getId() + " deletada.");
		em.getTransaction().commit();
	}

}
