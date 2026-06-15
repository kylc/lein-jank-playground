# lein-jank-playground

Example projects to exercise the lein-jank native build system.

Requirements:
- Recent install of `lein-jank` plugin
- C++ compiler
- cmake
- babashka
- pkg-config
- libglfw3-dev

Example usage:

``` sh
cd json-formatter

# Release build
lein with-profile +release do clean, run
```
