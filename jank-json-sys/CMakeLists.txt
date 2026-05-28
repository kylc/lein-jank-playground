cmake_minimum_required(VERSION 3.30)
project(jank_json_sys VERSION 1.0 LANGUAGES CXX)

include(FetchContent)
FetchContent_Declare(json URL https://github.com/nlohmann/json/releases/download/v3.12.0/json.tar.xz)
FetchContent_MakeAvailable(json)

include(GNUInstallDirs)
install(
  DIRECTORY "${json_SOURCE_DIR}/include/"
  DESTINATION "${CMAKE_INSTALL_INCLUDEDIR}"
)
