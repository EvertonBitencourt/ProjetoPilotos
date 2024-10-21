package com.senacead.pilotos.model;

import java.util.ArrayList;
import java.util.List;

public class ListaDados {

    private static final List<Piloto> listaPilotos = new ArrayList();
    private static final List<Avaliacoes> listaAvaliacao = new ArrayList<>();

    public static void adicionarPiloto(Piloto piloto) {
        piloto.setId(listaPilotos.size() + 1);
        piloto.setStatus(true);
        listaPilotos.add(piloto);
    }
    
    public static List<Piloto> listarPilotos(){
        return listaPilotos;
    }
    
    public static void excluirPiloto(Integer id){
        for (Piloto p : listaPilotos) {
            if (p.getId() == id) {
                listaPilotos.remove(p);
                break;
            }
        }
    }
    
    public static Piloto obtemPiloto(Integer id){
        Piloto pilotoEncontrado = new Piloto(); // criar o objeto
        for (Piloto p : listaPilotos) {
            if (p.getId() == id) {
                pilotoEncontrado = p;
                break;
            }
        }
       return pilotoEncontrado;
    }
    
    public static void atualizarPiloto(Piloto piloto){
        for (Piloto p : listaPilotos) {
                if (p.getId() == piloto.getId()) {
                    p.setNome(piloto.getNome());
                    p.setEquipe(piloto.getEquipe());
                    break;
                }
            }
    }
    
    public static void adicionarAvaliacao(Avaliacoes avaliacoes) {
        avaliacoes.setId(listaAvaliacao.size()+1);
        listaAvaliacao.add(avaliacoes);
    }
    
    public static void excluirAvaliacao(Integer id){
        for (Avaliacoes aval : listaAvaliacao) {
            if (aval.getId() == id) {
                listaAvaliacao.remove(aval);
                break;
            }
        }
    }
    
    public static List<Avaliacoes> listaAvaliacoes(Integer idPiloto){
        List<Avaliacoes> avaliacaoEncontrada = new ArrayList<>();
        for(Avaliacoes a : listaAvaliacao){
            if(a.getPiloto().getId() == idPiloto){
			avaliacaoEncontrada.add(a);
			
		}
	}
        return avaliacaoEncontrada;
    }
}
