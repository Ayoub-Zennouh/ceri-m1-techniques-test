package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {
	
	List<PokemonMetadata> pokemonMetadata;
	
	public PokemonMetadataProvider() {
		pokemonMetadata = new ArrayList<PokemonMetadata>();
		pokemonMetadata.add(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
		pokemonMetadata.add(new PokemonMetadata(133, "Aquali", 186, 168, 260));
	}

	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		
		if(index < 0 || index > 150)
			throw new PokedexException("Invalid index");
		
		for(PokemonMetadata metadata: pokemonMetadata)
			if(metadata.getIndex() == index)
				return metadata;
		
		return null;
	}

}
