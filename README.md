[Multiplatform](/multiplatform.md)

## Architecture details

<img width="1335" alt="Screenshot 2023-06-28 at 15 18 38" src="https://github.com/kacsogellert/Series/assets/8707773/d2c10d49-960a-4ba6-bc9b-17593cd441ab">
 
- #### app:
   The base application module encompasses essential components such as the application class, main activity, navigation setup, and dependency injection for other modules. This module serves as the foundation for the application, providing a centralized structure and functionality that are shared across different modules. It facilitates the initialization and configuration of the application, sets up the main activity as the entry point, establishes navigation mechanisms for seamless user flow, and implements dependency injection to promote modular and scalable development practices.
    
- #### shared:
  -  ui
    
      This module focuses on the configuration of app theming using Compose, allowing for a consistent and visually appealing user interface. It also includes the utilization of common composables that can be shared and reused across different features, promoting code modularity and reusability. Additionally, the module implements common composable extensions, such as effects and modifiers, which enhance the functionality and appearance of the composables.
  -  domain

     This module contains common domain methods such as Resultwrapper
  -  data

     This module contains networking setup such as the implementation of Retrofit, interceptors, and other related components.

- #### feature:series:
  - ui

    This module focuses on the implementation of a feature screen along with its associated ViewModel. It encompasses the user interface elements and logic specific to the feature,      
  - domain
    
      - api
        
        This module is dedicated to defining the interfaces for the use cases and housing the model classes. It serves as a crucial layer for encapsulating the business logic and defining the operations specific to the module. By employing interface-based design, the module promotes loose coupling and facilitates modularity.

        Furthermore, the module provides interfaces that outline the contract for repository implementations. These interfaces establish the expected behavior and functionality for interacting with data sources, enabling the decoupling of data access from the module itself. This separation enhances maintainability and flexibility, allowing for different repository implementations to be seamlessly integrated without impacting the core functionality of the module.

  
      - implementation
    
         This module is responsible for implementing the use case interfaces defined in the api module
    
  - data

    This module focuses on the implementation of repository interfaces defined in the domain module, as well as the creation of request and response models. It also includes the configuration and management of network services for handling remote data retrieval and communication. Furthermore, the module encompasses the setup and implementation of both remote and local data sources, enabling efficient data access and management within the application. Everything in this module has internal visibility
       

  

