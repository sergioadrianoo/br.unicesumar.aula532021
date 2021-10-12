package br.unicesumar.aula.controle;
 
import br.unicesumar.aula.exceptions.DadoConsultadoException;
import br.unicesumar.aula.modelo.Projeto;
import java.util.ArrayList;
 
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
 
public class ProjetoImpl implements ProjetoDAO {
    //Collection que irá armazenar todos os projetos
    private static Set<Projeto> projetos = new HashSet<>();

    @Override
    public void adicionar(Projeto projeto) {
        projetos.add(projeto);
    }
 
    @Override
    public List<Projeto> listar() {        
        List<Projeto> novaLista = new ArrayList<>();
        novaLista.addAll(projetos);
        
        return novaLista;
    }
 
    @Override
    public Projeto consultarPorNome(String nome)throws DadoConsultadoException {
        Projeto consulta = new Projeto();
        consulta.setNome(nome);
        boolean a = projetos.contains(consulta);
        if(!a){throw new DadoConsultadoException("Projeto não encontrado!");}

        for(Projeto p : projetos){
            consulta = p;
            if(consulta.getNome().equals(nome)){
                break;
            }
        }
        return consulta;
    }
 
    @Override
    public void alterar(String nome, Projeto projeto) throws DadoConsultadoException {
        Projeto consulta = new Projeto();
        consulta.setNome(nome);
        boolean a = projetos.contains(consulta);
        if(!a){throw new DadoConsultadoException("Projeto não encontrado!");}
        
        for(Projeto p : projetos){
            consulta = p;
            if(consulta.getNome().equals(nome)){
                projetos.remove(p);
                consulta = projeto;
                projetos.add(consulta);
                break;
            }
        }
    }
 
    @Override
    public void excluir(Projeto projeto) throws DadoConsultadoException, UnsupportedOperationException {

    }
 
    @Override
    public void excluir(String nome) throws DadoConsultadoException, UnsupportedOperationException {
        Projeto consulta = new Projeto();
        consulta.setNome(nome);
        boolean a = projetos.contains(consulta);

        if(!a){throw new DadoConsultadoException("Projeto não encontrado!");}
        
        for(Projeto p : projetos){
            consulta = p;
            if(consulta.getNome().equals(nome)){
                projetos.remove(p);
                break;
            }
        }
    }
}