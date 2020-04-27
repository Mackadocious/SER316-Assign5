Design Pattern Plans:

Because the types of animals will all be very similar classes I plan to 
use the composite design pattern to group the animal objects into a single
object. 

I plan to use the builder pattern to create farms and assign different attributes to each farm.

I will be using the suggestion to use the mediator pattern to create ticks, where currency will be generated
along with keeping track of animal tasks and growing crops. 


-------------------Update after completion-----------------------------

WARNING: Due to my simulation being probability based, and in order to get the maximum coverage, the build will occasionally fail because a test because of something being randomly selected. If this happens, rebuild. It will always run.

- Link to Video: https://www.youtube.com/watch?v=6ArZfoL7ink&feature=youtu.be
- Github: https://github.com/Mackadocious/SER316-Assign5
- TravisCI: https://travis-ci.com/github/Mackadocious/SER316-Assign5


Design Patterns:

- The Singleton pattern was used to ensure that once the game object was created in the game loop, it was only created one time. 

Factory Pattern:
- Used to generate types of Fish for fish farms
- Used to generate types of crops on crop farms
- Used to generate types of animals on animal farms
- Used to generate types of predators

Builder Pattern:
- Used to generate types of Farms(3 types)
- Used to generate types of farmers (4 types)

Observer Pattern:
- Used to inform all animal objects within a farm that a disease has taken over the farm and they are now sick
	It also informs them if certain objects have recovered. When an animal dies, it is removed as an observer.
- Used to inform all crop objects within a crop farm that a disease has taken over the farm and it is now diseased
- It also informs them if certain objects have recovered. When an crop patch dies, it is removed as an observer.
- Used to inform all crop objects within a crop farm that a disease has taken over the farm and it is now diseased
- It also informs them if certain objects have recovered. When an crop patch dies, it is removed as an observer.
- Used to notify all farms to run their individual game loops from the main game loop.



Requirements met:
- New world starts with one farm. 
- Animals can be different types (fish, animal, crop). Builder pattern to select a type
- The simulation runs on cycles, and the observer pattern is used to notify farms that the night cycle has started and predators activate.
- Passive currency is generated by cash farmers every individual farm loop. Cash farmers have a chance of generating some extra currency for the 	farm
- Farms are automatically upgraded once the farm aquires enough currency (at the end of the main game loop all farms are checked using the observer 	pattern) 3 farmers are removed, and a certain amount of currency is also removed
- A set number of farmers start on a single farm, this is arranged by a random number. More are hired every cycle. The type is random and uses the 
	Builder pattern to create the type of farmer
- Farmers have affinities and the builder pattern is used to select the affinity. For example: if a animal farmer works on an animal farm, they 	will generate more income for the farm rather than a fish farmer. 
- Animals/crops/caviar are harvested every set amount of days. This varies for each type
- All farms are notified using the observer pattern that the night cycle has begun. During the night predator types can be generated on certain 	farms. Certain predators will only do damage to certain types of farms. For example, if a locust is generated on an animal farm, it will not do any 	harm. If it is generated on a crop farm, the crops have a chance to become decimated. 
- Animals have a chance to be born every cycle, but the probability is lower. 
- Animals, fish, crops live for certain days, unless they become diseased or sick. Different types live for different lengths of time. 
- Animals, fish, crops have a natural life cycle and cannot produce when they are young. The age to which they can produce varies by type.
- Animals/crops/fish cost currency to purchase, they are different prices. 









