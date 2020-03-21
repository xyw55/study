/*
 * @(#) GenericsTest.java 2019-12-07
 *
 * Copyright 2019 NetEase.com, Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author xyw55
 * @version 2019-12-07
 */
public class GenericsTest {

    public static void main(String[] args) {
        List<Animal> animalList = new ArrayList<>();
        List<Dog> dogList = new ArrayList<>();
        List<SamoyedDog> samoyedDogList = new ArrayList<>();

//        List<? extends Dog> extendsDogFromAnimalList = animalList;
        List<? extends Dog> extendsDogFromDogList = dogList;
        List<? extends Dog> extendsDogFromSamoyedDog = samoyedDogList;

        List<? super Dog> superDogFromAnimalList = animalList;
        List<? super Dog> superDogFromDog = dogList;
//        List<? super Dog> superDogFromSamoyed = samoyedDogList;


//        extendsDogFromDogList.add(new Animal());
//        extendsDogFromDogList.add(new Dog());
//        extendsDogFromDogList.add(new SamoyedDog());

//        superDogFromDog.add(new Animal());
        superDogFromDog.add(new Dog());
        superDogFromDog.add(new SamoyedDog());

        Animal dog2 = extendsDogFromDogList.get(0);
        Dog dog = extendsDogFromDogList.get(0);
//        SamoyedDog samoyedDog = extendsDogFromDogList.get(0);

//        Dog dog1 = superDogFromDog.get(0);
        Object animal = superDogFromDog.get(0);


    }

}
