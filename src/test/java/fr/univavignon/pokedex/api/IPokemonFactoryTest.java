package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonFactoryTest {
	
	@Test
	public void createPokemonTest() {
		
		Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		Pokemon pokemon2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
		
		IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);
		
		when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(pokemon1);
		when(pokemonFactory.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(pokemon2);

		
		assertEquals(pokemon1, pokemonFactory.createPokemon(0, 613, 64, 4000, 4));
		assertEquals(pokemon2, pokemonFactory.createPokemon(133, 2729, 202, 5000, 4));

	}

}
