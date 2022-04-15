package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

public class IPokedexFactoryTest {
	
	@Test
	public void createPokedexTest() {
		
		IPokemonMetadataProvider metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
		
		IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);
		
		IPokedexFactory pokedexFactory = Mockito.mock(IPokedexFactory.class);
		
		IPokedex pokedex = Mockito.mock(IPokedex.class);
		
		when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);
		
		assertEquals(pokedex, pokedexFactory.createPokedex(metadataProvider, pokemonFactory));
		
	}

}
