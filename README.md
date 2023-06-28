#### Architecture diagramm

<img width="1082" alt="Screenshot 2023-06-28 at 10 32 30" src="https://github.com/kacsogellert/Series/assets/8707773/bd80c2cb-07da-4ad3-8bfa-9e69aba5e42e">
 
- ##### app:
    
- ##### shared:
  -  ui
     - app theming setup wih compose
     - common composables used accross different features
     - common composable extensions like effects, modifiers
  -  domain
     - resultwrapper used by different feature domain modules and other common domain
  -  data
     - networking setup: retrofit, interceptors etc  

- ##### feature:series:
  - ui
     - feature screen, viemodel       
  - domain
     - use cases
     - model classes 
     - interfaces for repositories
  - data
     - implementation for the repositories interfaces from doamin
     - response/request models
     - network services
     - remote/local sources
       

  

