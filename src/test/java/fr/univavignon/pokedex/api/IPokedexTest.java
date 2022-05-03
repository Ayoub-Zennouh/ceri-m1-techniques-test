package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;


public class IPokedexTest {
	
	IPokedexFactory pokedexFactory;
	IPokemonMetadataProvider metadataProvider;
	IPokemonFactory pokemonFactory;
	IPokedex pokedex;
	Pokemon pokemon1;
	Pokemon pokemon2;
	
	
	
	@Before 
	public void initialize() {
		
		pokedexFactory = new PokedexFactory();
		metadataProvider = new PokemonMetadataProvider();
		pokemonFactory = new PokemonFactory();
		pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
		
		pokemon1 = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
		pokemon2 = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
		
		pokedex.addPokemon(pokemon1);
		pokedex.addPokemon(pokemon2);
	}
	
	@Test
	public void sizeTest() {
		assertEquals(2, pokedex.size());
	}
	
	@Test
	public void addPokemonTest() {
		assertEquals(2, pokedex.addPokemon(pokemon1));
	}
	
	@Test
	public void getPokemonTest() throws PokedexException {		
		assertEquals(pokemon1, pokedex.getPokemon(0));
		assertEquals(pokemon2, pokedex.getPokemon(1));
		
		assertThrows(PokedexException.class, () -> pokedex.getPokemon(-1));
	}
	
	@Test
	public void getPokemonsTest() {
		assertEquals(2, pokedex.getPokemons().size());
		assertEquals(pokemon1, pokedex.getPokemons().get(0));
		assertEquals(pokemon2, pokedex.getPokemons().get(1));
	}
	
	@Test
	public void getPokemonsCompTest() {		
		assertEquals(pokemon1, pokedex.getPokemons(PokemonComparators.INDEX).get(0));
		assertEquals(pokemon2, pokedex.getPokemons(PokemonComparators.INDEX).get(1));

		assertEquals(pokemon1, pokedex.getPokemons(PokemonComparators.CP).get(0));
		assertEquals(pokemon2, pokedex.getPokemons(PokemonComparators.CP).get(1));

		
		assertEquals(pokemon2, pokedex.getPokemons(PokemonComparators.NAME).get(0));
		assertEquals(pokemon1, pokedex.getPokemons(PokemonComparators.NAME).get(1));
	}

}
