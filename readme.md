# Dagger example for scoping component on view model

Using extensions from [Fred Porciuncula's talk](https://www.youtube.com/watch?v=9fn5s8_CYJI) ([my notes on the talk](https://notes.alexgabor.com/path/Android/Video%20notes/It's%20complicated,%20but%20it%20doesn't%20have%20to%20be:%20a%20Dagger%20journey%20by%20Fred%20Porci%C3%BAncula.md))

In this example `ViewModelComponent` is a subcomponent annotated with `@ViewModelScope`. This means that classes annotated with it will have a single instance in the dependency graph.

For example, if your architecture has one activity per flow then this gives you the possibility to scope dependencies on a flow.
 
