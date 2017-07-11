package br.ufc.sippa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.sippa.model.Turma;
import br.ufc.sippa.model.Usuario;
import br.ufc.sippa.repository.PresencaRepository;
import br.ufc.sippa.repository.TurmaRepository;
import br.ufc.sippa.repository.UsuarioRepository;

@Service
public class TurmaService {
	@Autowired
	TurmaRepository repoTurma;
	@Autowired
	UsuarioRepository repoUsuario;
	@Autowired
	PresencaRepository repoPresenca;

	//	public Turma save(String periodo, Disciplina disc, Usuario professor){
	//	Turma turma = new Turma();
	//	turma.setPeriodo(periodo);
	//	turma.setDisciplina(disc);
	//	turma.setProfessor(professor);
	//	turma.setPlano(null);
	//	turma.setAlunos(null);
	//	repoTurma.save(turma);
	//	return turma;
	//}
	public Turma save(Turma turma){
		return repoTurma.save(turma);
	}

	public void alocarAlunos(Integer idTurma,List<Usuario> alunos){
		Turma turma = repoTurma.findById(idTurma);
		for (Usuario a : alunos) {
			turma.addAlunos(a);
			//			Usuario aluno = repoUsuario.findOne(a.getId());
			//			turma.getAlunos().add(aluno);			
		}
		repoTurma.save(turma);
	}

	public Turma findOne(Integer id){
		return repoTurma.findOne(id);
	}

	public List<Turma> findAll(){
		return repoTurma.findAll();
	}

	public List<Turma> findByPerido(String periodo){
		return repoTurma.findByPeriodo(periodo);
	}

	public List<Turma> findByProfessor(Usuario professor){
		return repoTurma.findByProfessor(professor);
	}

	public void delete(Integer id) {
		repoTurma.delete(repoTurma.findById(id));		
	}
}
