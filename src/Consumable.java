
// Anything a player physically interacts with
// Specifically, anything that can be an input/output to a converter, broadly defined (cubes/colonies/converters/research teams/...)
public interface Consumable {

	// Get the name of the resource
	public String getName();

	// See whether the other resource provided is the same resource as this
	public boolean equals(Object otherResource);

	// Allowing for hashing
	public int hashCode();
	
	// Gets the type of the object within the game (cube, converter, colony, etc.)
	public String objectType();
	
	// How much the object is worth (in victory points) at the end of the game
	public double scoringValue();
	
	// Does a player have this, or does no one have it (yet)?
	public bool isPlayerOwned();
	
	// Which player has this?
	// If isPlayerOwned is false, has undefined behavior
	public Player owningPlayer();
	
	// Is it in the donation bin or does the player truly own it?
	// If isPlayerOwned is false, has undefined behavior
	public bool isDonation();

}
