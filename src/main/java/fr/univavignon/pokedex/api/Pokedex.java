package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {
	
	private List<Pokemon> pokemons;
	IPokemonFactory pokemonFactory;
	IPokemonMetadataProvider metadataProvider;
	
	
	public Pokedex() {
		metadataProvider = new PokemonMetadataProvider();
		pokemonFactory = new PokemonFactory();
	}

	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		return metadataProvider.getPokemonMetadata(index);
	}

	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
	}

	@Override
	public int size() {
		return pokemons.size();
	}

	@Override
	public int addPokemon(Pokemon pokemon) {
		pokemons.add(pokemon);
		return pokemons.size()-1;
	}

	@Override
	public Pokemon getPokemon(int id) throws PokedexException {
		try {
			return pokemons.get(id);
		}catch(Exception e) {
			throw new PokedexException("Pokemon not found");
		}
	}

	@Override
	public List<Pokemon> getPokemons() {
		return pokemons;
	}

	@Override
	public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
		List<Pokemon> sortedList = pokemons;
		Collections.sort(sortedList, order);
		
		return sortedList;
	}
	
}
