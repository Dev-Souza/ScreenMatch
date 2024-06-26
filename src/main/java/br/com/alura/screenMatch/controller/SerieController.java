package br.com.alura.screenMatch.controller;

import br.com.alura.screenMatch.dto.EpisodioDTO;
import br.com.alura.screenMatch.dto.SerieDTO;
import br.com.alura.screenMatch.model.Episodio;
import br.com.alura.screenMatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.http.Path;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private SerieService servico;

    @GetMapping
    public List<SerieDTO> obterSeries(){
        return servico.obterTodasAsSeries();
    }

    @GetMapping("top5")
    public List<SerieDTO> obterTopSeries() {
        return servico.obterTop5Series();
    }

    @GetMapping("/lancamentos")
    public List<SerieDTO> obterLancamento(){
        return servico.obterLancamentos();
    }

    @GetMapping("/{id}")
    public SerieDTO obterPorId(@PathVariable Long id){
        return servico.obterPorId(id);
    }

    @GetMapping("/{id}/temporadas/todas")
    public List<EpisodioDTO> obterTodasTemporadas(@PathVariable Long id){
        return servico.obterTodasTemporadas(id);
    }

    @GetMapping("/{id}/temporadas/{numero}")
    public List<EpisodioDTO> obterDadosTemporadaPorId(@PathVariable Long id, @PathVariable Long numero){
        return servico.obterDadosTemporadaPorId(id, numero);
    }

    @GetMapping("/categoria/{nomeGenero}")
    public List<SerieDTO> obterSeriesPorGenero(@PathVariable String nomeGenero){
        return servico.obterSeriesPorGenero(nomeGenero);
    }

    @GetMapping("/{idSerie}/temporadas/top5")
    public List<EpisodioDTO> obterTop5EpisodiosDeUmaSerie(@PathVariable Long idSerie){
        return servico.obterTop5EpisodiosDeUmaSerie(idSerie);
    }
}
