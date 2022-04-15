package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class IPokemonMetadataProviderTest {

	@Test
	public void getPokemonMetadataTest() throws PokedexException{
		PokemonMetadata pokemonMetadata1 = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
		PokemonMetadata pokemonMetadata2 = new PokemonMetadata(133, "Aquali", 186, 168, 260);
		IPokemonMetadataProvider pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
		
		when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(pokemonMetadata1);
		when(pokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(pokemonMetadata2);
		when(pokemonMetadataProvider.getPokemonMetadata(anyInt())).thenAnswer(new Answer<PokemonMetadata>(){
			@Override
			public PokemonMetadata answer(InvocationOnMock invocation) throws PokedexException {
				int index = invocation.getArgument(0);
				if(index == 0)
					return pokemonMetadata1;
				else if(index == 133)
					return pokemonMetadata2;
				else if(index < 0 || index > 150)
					throw new PokedexException("Invalid pokemon index");
				return null;
			}
		});

		assertEquals(pokemonMetadata1, pokemonMetadataProvider.getPokemonMetadata(0));
		assertEquals(pokemonMetadata2, pokemonMetadataProvider.getPokemonMetadata(133));
		assertThrows(PokedexException.class, () -> pokemonMetadataProvider.getPokemonMetadata(-1));
	}
}
