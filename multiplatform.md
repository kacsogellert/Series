# Kotlin Multiplatform Coding Standards

## Table of Contents
- [Introduction](#introduction)
- [File and package Structure](#file-and-package-structure)
- [Naming conventions](#naming-conventions)
- [Code formatting](#code-formatting)
- [Code structure](#code-structure)
  - [General rules](#general-rules)
  - [Interface declaration](#interface-declaration)
  - [Implementation naming](#implementation-naming)
  - [Model classes](#model-classes)
    - [Response/Request classes](#responserequest-classes)
    - [Model class](#model-class)
  - [Use case](#use-case)
- [Dependency Management](#dependency-management)
- [Version Control](#version-control)
- [Conclusion](#conclusion)

## Introduction

These coding standards are designed to ensure consistency, readability, and maintainability in our Kotlin Multiplatform project. Adhering to these guidelines will help the development team produce high-quality, uniform code.

## File and package Structure

- Separate code into logical modules or packages based on functionality.
- Respect the Single Responisability principle
- Follow the standard Kotlin package naming convention (e.g., `com.example.module`).

## Naming conventions

- Use descriptive and meaningful names for classes, functions, variables, and packages.
- Class and Interface names should use UpperCamelCase (e.g., `MyClass`, `MyInterface`).
- Function and variable names should use lowerCamelCase (e.g., `myFunction`, `myVariable`).
- Constants should be in uppercase with underscores (e.g., `MY_CONSTANT`).
- Use clear and concise names that reflect the purpose of the code.

## Code formatting

- Use a consistent code formatting style across the project.
- Use a line length of around 180 characters.
- Place opening braces on the same line as the corresponding declaration (Kotlin convention).
- Maintain consistent spacing around operators and keywords.

## Code structure
### General rules

#### Interface declaration:

- Always declare interfaces to define the contract for accessing an implementation, in line with the Dependency Inversion Principle.
- If the interface is accessed from the implementation of another class, add the `internal` visiblity modifier

#### Implementation naming:

- The implementation should be name with the Default prefix
- Implementations should never be access from the client codebase, add the `internal` visiblity access modifirer

#### Example
```kotlin
interface SomeApi {    suspend fun someMethod()}
internal class DefaultSomeApi() : SomeApi {  override suspend fun someMethod()} {}
```
    	
### Model classes
#### Response/Request classes
 - Always declare separate kotlin data classes for the api response and requests objects
 - The fields in the request/response classes should be nullabe. This way the developer has more control over how to treat errors
 - The request/response classes should not be accesible by the client code, add the `internal` visiblity modifier
 - The request/response classes should be annotated with `@Serializable`
 - The fields should have the `@SerialName("")` annotattion
 
#### Model class
 - The model class should be a kotlin data class
 - Constructing the model object should be through an extension function placed in the model class's file
 - Throw specific expections when a response class has a null field that should be present

#### Example

```kotlin
@Serializable
internal data class ExampleResponse(
    @SerialName("id") val id: Int?
)

data class Example(
    val id: Int
)

internal fun Example(response: ExampleResponse) = Example(
    id = response.id ?: throw InvalidResponseException()
)
```

### Use case
- Client applications should always acess multiplatform code through use cases
- Use cases will propagate exceptions to the client apps
- Methods of the use case should be annotated with the exception thrown

#### Example
```kotlin
interface SomeMethodUseCase(){
     @Throws(Exception::class)
     suspend fun getData()
}

```

## Dependency management

- Use gradle as dependency management 
- Declare dependencies in a central location to ensure consistency across platforms `depndencies.kt` from the `buildSrc` module
- Regularly update dependencies to benefit from bug fixes and new features.
- If there is no good reason, do not use unstable dependencies

## Version control

- Use git to track changes and collaborate with the development team.
- Use gitFlow as the branching strategy
- Write clear and concise commit messages that describe the purpose of the changes.
- Use pull requests (or merge requests) for code review before merging into main branches.

## Conclusion

Adhering to these coding standards will contribute to the consistency, readability, and maintainability of the Kotlin Multiplatform project. Regularly review and update these guidelines as the project evolves to reflect the team's experience and changing best practices.
