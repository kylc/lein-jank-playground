cmake_minimum_required(VERSION 3.30)
project(jank_json VERSION 1.0 LANGUAGES CXX)

include(FetchContent)
FetchContent_Declare(json
  URL
  https://github.com/nlohmann/json/releases/download/v3.12.0/json.tar.xz)
FetchContent_MakeAvailable(json)

# TODO: Paths are different if extracted from jar or in source checkout. Ideally
# we leave the native source/include dirs untouched when including in the jar.
if(EXISTS "${CMAKE_CURRENT_SOURCE_DIR}/src")
    set(SRC_DIR "${CMAKE_CURRENT_SOURCE_DIR}/src/cpp")
    set(INCLUDE_DIR "${CMAKE_CURRENT_SOURCE_DIR}/include")
else()
    set(SRC_DIR "${CMAKE_CURRENT_SOURCE_DIR}")
    set(INCLUDE_DIR "${CMAKE_CURRENT_SOURCE_DIR}")
endif()

add_library(jank_json SHARED "${SRC_DIR}/jank_json.cpp")
target_link_libraries(jank_json PUBLIC nlohmann_json::nlohmann_json)
target_include_directories(jank_json PUBLIC "${INCLUDE_DIR}")
set_target_properties(jank_json PROPERTIES PUBLIC_HEADER "${INCLUDE_DIR}/jank_json.hpp")

include(GNUInstallDirs)
install(TARGETS jank_json
    LIBRARY DESTINATION ${CMAKE_INSTALL_LIBDIR}
    PUBLIC_HEADER DESTINATION ${CMAKE_INSTALL_INCLUDEDIR}
)
