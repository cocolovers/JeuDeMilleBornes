package cartes;

public abstract class Probleme extends Carte {
	protected Type type;

	public Type getType() {
		return type;
	}

	protected Probleme(Type type) {
		super();
		this.type = type;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Probleme probleme)
			return (getClass() == obj.getClass() && type.equals(probleme.getType()));
		return false;
	}
}
