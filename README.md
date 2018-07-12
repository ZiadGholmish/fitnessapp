# fitnessapp
A proof of concept to calculate the user steps and burned calories from google fitness api with the ability to add stages with rewards for each stage

## Getting Started
You have to clone the app and import in android studio then sync and you will be able to run it.

## Project structure 

**1. data Layer**
- Contains all my data whether come from the backend or from local database.
- Repository pattern to access these data and provide interface between the domain layer and the data layer.
- Factory pattern to decide which source i should fetch the data from.
- Room to manage the offline data for the steps and the offers as proof of concept.

**2. Domain Layer**
- Contains all my use business cases away from the dependencies of android paltform.
- All the use cases running in background process till they finish their work.

**3. Presentation Layer**
- The presentation layer specific for android and it brings the data from the domain layer.
- MVP pattern to structure the presentation layer and handle the logic of views from presneter not the activity.

## Libraries

1. Java
2. RXjava2
3. Dagger2
4. Room 
5. Retrofit


