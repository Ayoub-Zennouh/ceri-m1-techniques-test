package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonFactoryTest {
	
	@Test
	public void createPokemonTest() {
		IPokemonFactory pokemonFactory = new PokemonFactory();
		
		Pokemon pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
		assertEquals(0, pokemon.getIndex());
		assertEquals(613, pokemon.getCp());
		assertEquals(64, pokemon.getHp());
		assertEquals(4000, pokemon.getDust());
		assertEquals(4, pokemon.getCandy());
	}

}
