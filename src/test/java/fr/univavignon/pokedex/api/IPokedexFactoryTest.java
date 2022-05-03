package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class IPokedexFactoryTest {
	
	@Test
	public void createPokedexTest() {
		
		IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
		
		IPokemonFactory pokemonFactory = new PokemonFactory();
		
		IPokedexFactory pokedexFactory = new PokedexFactory();
		
		
		assertNotNull(pokedexFactory.createPokedex(metadataProvider, pokemonFactory));
	}

}
