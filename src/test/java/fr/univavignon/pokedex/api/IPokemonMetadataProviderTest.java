package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class IPokemonMetadataProviderTest {
	
	IPokemonMetadataProvider pokemonMetadataProvider;
	PokemonMetadata metadata;
	
	@Before 
	public void initialize() {
		pokemonMetadataProvider = new PokemonMetadataProvider();
	}

	@Test
	public void getPokemonMetadataTest() throws PokedexException{
		metadata = pokemonMetadataProvider.getPokemonMetadata(0);

		assertEquals("Bulbizarre", metadata.getName());
		assertEquals(126, metadata.getAttack());
		assertEquals(126, metadata.getDefense());
		assertEquals(90, metadata.getStamina());
		assertThrows(PokedexException.class, () -> pokemonMetadataProvider.getPokemonMetadata(-1));
	}
}
