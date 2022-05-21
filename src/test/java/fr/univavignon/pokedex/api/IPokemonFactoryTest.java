package fr.univavignon.pokedex.api;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IPokemonFactoryTest {
	
	@Test
	public void createPokemonTest() {
		IPokemonFactory pokemonFactory = new RocketPokemonFactory();
		
		Pokemon pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
		assertEquals(0, pokemon.getIndex());
		assertEquals(613, pokemon.getCp());
		assertEquals(64, pokemon.getHp());
		assertEquals(4000, pokemon.getDust());
		assertEquals(4, pokemon.getCandy());
		assertEquals("Bulbizarre", pokemon.getName());
		assertEquals(126, pokemon.getAttack());
		assertEquals(126, pokemon.getDefense());
		assertEquals(90, pokemon.getStamina());
		
	}

}
