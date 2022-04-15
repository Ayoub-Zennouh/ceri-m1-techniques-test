package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {
	
	@Test
	public void createTrainerTest() {
		IPokemonTrainerFactory pokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
		IPokedexFactory pokedexFactory = Mockito.mock(IPokedexFactory.class);
		IPokedex pokedex = Mockito.mock(IPokedex.class);
		
		PokemonTrainer pokemonTrainer = new PokemonTrainer("Trainer", Team.INSTINCT, pokedex);
		
		when(pokemonTrainerFactory.createTrainer("Trainer", Team.INSTINCT, pokedexFactory)).thenReturn(pokemonTrainer);
		
		assertEquals(pokemonTrainer, pokemonTrainerFactory.createTrainer("Trainer", Team.INSTINCT, pokedexFactory));
	}

}