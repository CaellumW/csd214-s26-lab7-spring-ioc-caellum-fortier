I didn't have a readme so I put one, I hope that is okay :)

The Vanishing Act: In Lab 5, you had to write a concrete repository class for every storage strategy, implementing manual transaction blocks [6, 7]. In Lab 7, you wrote a single interface extending JpaRepository [7]. Explain how Spring Data JPA replaces these hundreds of lines of boilerplate code.
Instead of writing hundreds of lines of code focusing on the semantics and every possible detail of the code, you get to write one interface and let spring do the run-time proxy generation, creating error handling and resource cleanup all behind the scenes (hence it vanishing). It also generates all of it at runtime so instead of generating it once, wanting to add something and having to completely destroy everything you created, all you do is just run it again. As for the databases, it uses the method names to make the queries for us, which is really nice because then you don't have to worry about preventing SQL injection, spring does that for you.


The Power of Annotations: What would happen at application startup if you forgot to add the @Service annotation to BookstoreService or DiscountService? Explain the concept of Component Scanning [6].
Component scanning is what spring uses to automatically detect your classes and create the appropriate beans. However, it can only do this because of the written annotations. So, if you forgot your annotations, spring would still run and create your application, but those beans that weren't labelled, wouldn't exist.


Constructor Injection vs. the new Keyword: Why is constructor injection systematically preferred over direct instantiation using new for services and repositories in enterprise frameworks? [6]
A big reason is that you simply can't instantiate interfaces with the new keyword, so in the case of using spring you HAVE to use constructor injection. The bigger reason is because of inversion of control, forcing the framework to handle the object creation and not the user. Which is good programming practice, but also ensures consistency throughout object creations.


Profiles vs. Manual Menus: Why is managing database environments using Spring Profiles (dev vs. prod) more secure and robust for deployment than using manual runtime choice menus like we did in Lab 5? [6]
It's more robust and secure due to the lack of manual intervention. On the developer's side, it is much simpler and straightforward to update the backend and add new things using spring, than it is to manually update everything. This also helps it be more secure by hiding a lot of settings and not allowing the user to have access to the set up process.
