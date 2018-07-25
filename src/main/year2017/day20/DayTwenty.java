package main.year2017.day20;

import java.io.File;
import java.math.BigInteger;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
//import java.util.HashSet;
import java.util.List;
//import java.util.Set;
import java.util.Map;
import java.util.Set;

import javax.print.attribute.SetOfIntegerSyntax;

import main.BigIntTriad;
import main.GeneralFunction;

public class DayTwenty {

	public static void executeStandardPart1() {
//		--- Day 20: Particle Swarm ---
//		Suddenly, the GPU contacts you, asking for help. Someone has asked it to simulate too many particles, and it won't be able to finish them all in time to render the next frame at this rate.
//
//		It transmits to you a buffer (your puzzle input) listing each particle in order (starting with particle 0, then particle 1, particle 2, and so on). For each particle, it provides the X, Y, and Z coordinates for the particle's position (p), velocity (v), and acceleration (a), each in the format <X,Y,Z>.
//
//		Each tick, all particles are updated simultaneously. A particle's properties are updated in the following order:
//
//		Increase the X velocity by the X acceleration.
//		Increase the Y velocity by the Y acceleration.
//		Increase the Z velocity by the Z acceleration.
//		Increase the X position by the X velocity.
//		Increase the Y position by the Y velocity.
//		Increase the Z position by the Z velocity.
//		Because of seemingly tenuous rationale involving z-buffering, the GPU would like to know which particle will stay closest to position <0,0,0> in the long term. Measure this using the Manhattan distance, which in this situation is simply the sum of the absolute values of a particle's X, Y, and Z position.
//
//		For example, suppose you are only given two particles, both of which stay entirely on the X-axis (for simplicity). Drawing the current states of particles 0 and 1 (in that order) with an adjacent a number line and diagram of current X positions (marked in parenthesis), the following would take place:
//
//		p=< 3,0,0>, v=< 2,0,0>, a=<-1,0,0>    -4 -3 -2 -1  0  1  2  3  4
//		p=< 4,0,0>, v=< 0,0,0>, a=<-2,0,0>                         (0)(1)
//
//		p=< 4,0,0>, v=< 1,0,0>, a=<-1,0,0>    -4 -3 -2 -1  0  1  2  3  4
//		p=< 2,0,0>, v=<-2,0,0>, a=<-2,0,0>                      (1)   (0)
//
//		p=< 4,0,0>, v=< 0,0,0>, a=<-1,0,0>    -4 -3 -2 -1  0  1  2  3  4
//		p=<-2,0,0>, v=<-4,0,0>, a=<-2,0,0>          (1)               (0)
//
//		p=< 3,0,0>, v=<-1,0,0>, a=<-1,0,0>    -4 -3 -2 -1  0  1  2  3  4
//		p=<-8,0,0>, v=<-6,0,0>, a=<-2,0,0>                         (0)   
//		At this point, particle 1 will never be closer to <0,0,0> than particle 0, and so, in the long run, particle 0 will stay closest.
//
//		Which particle will stay closest to position <0,0,0> in the long term?
		System.out.println("Day 20 Part 1");
		File file = new File("src/main/year2017/day20/input.txt");
		URI uri = file.toURI();
		System.out.println("Answer to part 1 is "
				+ getAnswerPartOneImperative(GeneralFunction.getStandardInputListOfStrings(uri)) + ".");

	}
	
	public static void executeStandardPart2() {
//		--- Part Two ---
//		To simplify the problem further, the GPU would like to remove any particles that collide. Particles collide if their positions ever exactly match. Because particles are updated simultaneously, more than two particles can collide at the same time and place. Once particles collide, they are removed and cannot collide with anything else after that tick.
//
//		For example:
//
//		p=<-6,0,0>, v=< 3,0,0>, a=< 0,0,0>    
//		p=<-4,0,0>, v=< 2,0,0>, a=< 0,0,0>    -6 -5 -4 -3 -2 -1  0  1  2  3
//		p=<-2,0,0>, v=< 1,0,0>, a=< 0,0,0>    (0)   (1)   (2)            (3)
//		p=< 3,0,0>, v=<-1,0,0>, a=< 0,0,0>
//
//		p=<-3,0,0>, v=< 3,0,0>, a=< 0,0,0>    
//		p=<-2,0,0>, v=< 2,0,0>, a=< 0,0,0>    -6 -5 -4 -3 -2 -1  0  1  2  3
//		p=<-1,0,0>, v=< 1,0,0>, a=< 0,0,0>             (0)(1)(2)      (3)   
//		p=< 2,0,0>, v=<-1,0,0>, a=< 0,0,0>
//
//		p=< 0,0,0>, v=< 3,0,0>, a=< 0,0,0>    
//		p=< 0,0,0>, v=< 2,0,0>, a=< 0,0,0>    -6 -5 -4 -3 -2 -1  0  1  2  3
//		p=< 0,0,0>, v=< 1,0,0>, a=< 0,0,0>                       X (3)      
//		p=< 1,0,0>, v=<-1,0,0>, a=< 0,0,0>
//
//		------destroyed by collision------    
//		------destroyed by collision------    -6 -5 -4 -3 -2 -1  0  1  2  3
//		------destroyed by collision------                      (3)         
//		p=< 0,0,0>, v=<-1,0,0>, a=< 0,0,0>
//		In this example, particles 0, 1, and 2 are simultaneously destroyed at the time and place marked X. On the next tick, particle 3 passes through unharmed.
//
//		How many particles are left after all collisions are resolved?
		System.out.println("Day 20 Part 2");
		File file = new File("src/main/year2017/day20/input.txt");
		URI uri = file.toURI();
		System.out.println("Answer to part 2 is "
				+ getAnswerPartTwoImperative(GeneralFunction.getStandardInputListOfStrings(uri)) + ".");

		
	}


	public static Integer getAnswerPartOneImperative(List<String> particleSetInitialization) {
		List<Particle> particleList = getParticleListFrom(particleSetInitialization);
		BigInteger min = particleList.get(0).getManhattanAccelerationFromOrigin();
		int particleID = 0;
		for (int i=0; i<particleList.size(); i++){
			if (-1 == particleList.get(i).getManhattanAccelerationFromOrigin().compareTo(min)){
				particleID = i;
				min = particleList.get(i).getManhattanAccelerationFromOrigin();
			} else if (0 == particleList.get(i).getManhattanAccelerationFromOrigin().compareTo(min)){
				//TODO
			}
		}
		return particleID;
	}
	

	private static Integer getAnswerPartTwoImperative(List<String> particleSetInitialization) {
		List<Particle> particleList = getParticleListFrom(particleSetInitialization);
		for (int i=0; i<1000; i++){//HACKY
			particleList = collisionCheck(particleList);
			for (Particle particle : particleList){
				particle.tick();
			}
		}
		return particleList.size();
	}

	private static List<Particle> collisionCheck(List<Particle> particleList) {
		//Set<Particle> listOfParticlesToDelete = new HashSet<>();
		Set<Integer> setOfIDsToDelete = new HashSet<>();
		for (int i=0; i<particleList.size(); i++) {
			for (int v=i+1; v<particleList.size(); v++){
				if (
						(particleList.get(i).getCurrentXCoordPosition().equals(particleList.get(v).getCurrentXCoordPosition()))
&&						(particleList.get(i).getCurrentYCoordPosition().equals(particleList.get(v).getCurrentYCoordPosition()))
&&						(particleList.get(i).getCurrentZCoordPosition().equals(particleList.get(v).getCurrentZCoordPosition()))
								){
					setOfIDsToDelete.add(i);
					setOfIDsToDelete.add(v);

				}
			}
		}
		List<Integer> arrayListOfIDsToDelete = new ArrayList<>();
		for (Integer idNum : setOfIDsToDelete){
			arrayListOfIDsToDelete.add(idNum);
		}
		
		Collections.sort(arrayListOfIDsToDelete);
		for (int i=arrayListOfIDsToDelete.size()-1; i>=0; i--){
			particleList.remove(particleList.get(arrayListOfIDsToDelete.get(i)));
		}
		
		return particleList;

	}

	private static List<Particle> collisionCheckDoesNotWork(List<Particle> particleList) {
		Map<BigIntTriad, Particle> particleMap = new HashMap<>();
		for (Particle particle : particleList) {
			BigIntTriad newTriad = new BigIntTriad();
			newTriad.setXCoord(particle.getCurrentXCoordPosition());
			newTriad.setYCoord(particle.getCurrentYCoordPosition());
			newTriad.setZCoord(particle.getCurrentZCoordPosition());
			particleMap.put(newTriad, particle);//this should resolve collisions but does not :(
		}
		Collection<Particle> setParticleCollection = particleMap.values();
		List<Particle> setParticleList = new ArrayList<>();
		for (Particle particle : setParticleCollection){
			setParticleList.add(particle);
		}
		return setParticleList;
	}

	private static List<Particle> getParticleListFrom(List<String> particleSetInitialization) {
		List<Particle> particleList = new ArrayList<>();
		for (String particleSetString : particleSetInitialization){
			Particle particle = new Particle();
			String[] positionVelocityAcceleration = particleSetString.split("\\s+");
			String initialPosition = positionVelocityAcceleration[0];
			initialPosition = initialPosition.substring(3);
			initialPosition = initialPosition.substring(0, initialPosition.length()-2);
			String[] positionSet = initialPosition.split("\\,");
			particle.setCurrentXCoordPosition(BigInteger.valueOf(Integer.parseInt(positionSet[0])));
			particle.setCurrentYCoordPosition(BigInteger.valueOf(Integer.parseInt(positionSet[1])));
			particle.setCurrentZCoordPosition(BigInteger.valueOf(Integer.parseInt(positionSet[2])));
			String initialVelocity = positionVelocityAcceleration[1];
			initialVelocity = initialVelocity.substring(3);
			initialVelocity = initialVelocity.substring(0, initialVelocity.length()-2);
			String[] velocitySet = initialVelocity.split("\\,");
			particle.setCurrentXCoordVelocity(BigInteger.valueOf(Integer.parseInt(velocitySet[0])));
			particle.setCurrentYCoordVelocity(BigInteger.valueOf(Integer.parseInt(velocitySet[1])));
			particle.setCurrentZCoordVelocity(BigInteger.valueOf(Integer.parseInt(velocitySet[2])));
			String initialAcceleration = positionVelocityAcceleration[2];
			initialAcceleration = initialAcceleration.substring(3);
			initialAcceleration = initialAcceleration.substring(0, initialAcceleration.length()-1);
			String[] accelerationSet = initialAcceleration.split("\\,");
			particle.setCurrentXCoordAcceleration(BigInteger.valueOf(Integer.parseInt(accelerationSet[0])));
			particle.setCurrentYCoordAcceleration(BigInteger.valueOf(Integer.parseInt(accelerationSet[1])));
			particle.setCurrentZCoordAcceleration(BigInteger.valueOf(Integer.parseInt(accelerationSet[2])));
			particleList.add(particle);
		}
		return particleList;
	}


}
