package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;


public class IPokedexTest {
	
	@Test
	public void sizeTest() {
		List<Pokemon> pokemons = new ArrayList<Pokemon>();
		pokemons.add(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56));
		pokemons.add(new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100));
		
		IPokedex pokedex = Mockito.mock(IPokedex.class);
		
		when(pokedex.size()).thenReturn(pokemons.size());
		
		assertEquals(2, pokedex.size());
	}
	
	@Test
	public void addPokemonTest() {
		IPokedex pokedex = Mockito.mock(IPokedex.class);
		
		Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56); 
		
		when(pokedex.addPokemon(pokemon)).thenReturn(pokemon.getIndex());
		
		assertEquals(0, pokedex.addPokemon(pokemon));
	}
	
	@Test
	public void getPokemonTest() throws PokedexException {
		List<Pokemon> pokemons = new ArrayList<Pokemon>();
		IPokedex pokedex = Mockito.mock(IPokedex.class);
		
		Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		Pokemon pokemon2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100); 
		
		
		pokemons.add(pokemon1);
		pokemons.add(pokemon2);
		
		when(pokedex.getPokemon(anyInt())).thenAnswer(new Answer<Object>() {

			@Override
			public Object answer(InvocationOnMock invocation) throws PokedexException {
				Object[] args = invocation.getArguments();
				int index = (int) args[0];
				for(Pokemon pokemon : pokemons)
					if(pokemon.getIndex() == index)
						return pokemon;
					else if(index < 0 || index > 150)
						throw new PokedexException("Invalid pokemon index");
				return null;
			}
			
		});
		
		assertEquals(pokemon1, pokedex.getPokemon(0));
		assertThrows(PokedexException.class, () -> pokedex.getPokemon(-1));
	}
	
	@Test
	public void getPokemonsTest() {
		List<Pokemon> pokemons = new ArrayList<Pokemon>();
		IPokedex pokedex = Mockito.mock(IPokedex.class);

		Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		Pokemon pokemon2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100); 
		
		
		pokemons.add(pokemon1);
		pokemons.add(pokemon2);
		
		when(pokedex.getPokemons()).thenReturn(pokemons);
		
		assertEquals(pokemons, pokedex.getPokemons());
	}
	
	@Test
	public void getPokemonsCompTest() {
		Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		Pokemon pokemon2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
		
		List<Pokemon> pokemonsByIndex = List.of(pokemon1, pokemon2);
		List<Pokemon> pokemonsByCp = List.of(pokemon2, pokemon1);
		List<Pokemon> pokemonsByName = List.of(pokemon2, pokemon1);
		
		IPokedex pokedex = Mockito.mock(IPokedex.class);
				
		when(pokedex.getPokemons(PokemonComparators.INDEX)).thenReturn(pokemonsByIndex);
		when(pokedex.getPokemons(PokemonComparators.CP)).thenReturn(pokemonsByCp);
		when(pokedex.getPokemons(PokemonComparators.NAME)).thenReturn(pokemonsByName);
		
		
		assertEquals(pokemonsByIndex, pokedex.getPokemons(PokemonComparators.INDEX));
		assertEquals(pokemonsByCp, pokedex.getPokemons(PokemonComparators.CP));
		assertEquals(pokemonsByName, pokedex.getPokemons(PokemonComparators.NAME));
	}

}
