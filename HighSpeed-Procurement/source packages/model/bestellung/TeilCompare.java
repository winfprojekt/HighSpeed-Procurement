package model.bestellung;

import java.util.Comparator;

public class TeilCompare implements Comparator<Teilbestellung>{
	
	@Override
	public int compare(Teilbestellung o1, Teilbestellung o2) {
		// TODO Auto-generated method stub
		return o1.getLiefID().compareTo(o2.getLiefID());
	}
}
