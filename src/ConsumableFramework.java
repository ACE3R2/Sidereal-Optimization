
// General approach to implementing Consumable interface
// Some parts may need to overridden for specific implementations, especially having to do with name and score
// Best practice is to always override equals for more specific type checking
public abstract class ConsumableFramework implements Consumable {
	private final String name;
	private Player owner;
	private boolean donation;
	
	// Starts out of play
	public ConsumableFramework(String consumableName) {
		name = consumableName;
		owner = null;
		donation = false;
	}
	
	// Starts owned by a player
	public ConsumableFramework(String consumableName, Player consumableOwner) {
		name = consumableName;
		owner = consumableOwner;
		donation = false;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean equals(Object otherResource) {
		return otherResource instanceof ConsumableFramework && this.getName().equals(((ConsumableFramework)otherResource).getName());
	}
	
	public int hashCode() {
		return name.hashCode();
	}
	
	abstract String objectType();
	
	// Unless it explicitly has a scoring value, everything is 0
	public double scoringValue() {
		return 0.0;
	}
	
	public bool isPlayerOwned() {
		return owner != null;
	}
	
	// Returns null if unowned
	public Player owningPlayer() {
		return owner;
	}
	
	public bool isDonation() {
		return donation;
	}
	
	public void makeDonation() {
		donation = true;
	}
	
	// Goes from unowned to owned by p
	public void boughtBy(Player p) {
		owner = p;
	}
	
	// Goes from current player to p
	// Different from boughtBy in that it clears donation status, but since out-of-play objects
	// cannot be donation goods, it may not matter
	public tradedTo(Player p) {
		owner = p;
		donation = false;
	}
	
	// Returns out of play (and clears donation status, if necessary)
	public spent() {
		owner = null;
		donation = false;
	}
}