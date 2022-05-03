package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {
	

	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {		
		IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
		PokemonMetadata metadata;
		try {
			double iv = Math.random();
			metadata = metadataProvider.getPokemonMetadata(index);
			return new Pokemon(metadata.getIndex(), metadata.getName(), metadata.getAttack(), metadata.getDefense(), metadata.getStamina(), cp, hp, dust, candy, iv);
		} catch (PokedexException e) {
			e.printStackTrace();
		}
		return null;
	}

}
