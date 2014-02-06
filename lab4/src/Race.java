import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class Race implements RaceInterface {
	private String name;
	private int maximumLapsInRace;
	private List<RaceCar> allCars;
	private int currentFinishPosition;
	
	public Race(String inName, int maximumLaps) {
		name = inName;
		maximumLapsInRace = maximumLaps;
		allCars = new ArrayList<>();
		currentFinishPosition = 1;
	}

	@Override
	public Iterator<RaceCar> iterator() {
		Collections.sort(allCars);
		return allCars.iterator();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getLapsInRace() {
		return maximumLapsInRace;
	}

	@Override
	public void add(RaceCar aCar) {
		allCars.add(aCar);
	}

	@Override
	public void addLap(int carNumber) {
		RaceCarInterface realCar = findCar(carNumber);
		
		if(realCar.isDisqualified()) {
			return;
		}
		
		if(realCar.getLapsCompleted() == maximumLapsInRace) {
			return;
		}
		
		realCar.addLap();
		
		if(realCar.getLapsCompleted() == maximumLapsInRace) {
			realCar.setFinishPosition(currentFinishPosition);
			currentFinishPosition++;
		}
		
	}

	@Override
	public RaceCarInterface findCar(int carNumber) {
		RaceCar fakeCar = new RaceCar("", carNumber);
		
		int position = allCars.indexOf(fakeCar);
		RaceCar realCar = allCars.get(position);
		
		return realCar;
	}

	@Override
	public void disqualify(int carNumber) {
		RaceCarInterface realCar = findCar(carNumber);
		realCar.disqualify();
	}

	@Override
	public RaceCarInterface findFinishPosition(int position) {
		for(RaceCar aCar : allCars) {
			if(aCar.getFinishPosition() == position) {
				return aCar;
			}
		}
		return null;
	}

	@Override
	public RaceCarInterface findRacer(RaceCarInterface findMe) {
		String nameToFind = findMe.getDriverName();
		
		for(RaceCar aCar : allCars) {
			String currentName = aCar.getDriverName();
			if(currentName.equals(nameToFind)) {
				return aCar;
			}
		}
		return null;
	}

}
