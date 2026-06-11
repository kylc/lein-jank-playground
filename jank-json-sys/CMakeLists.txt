cmake_minimum_required(VERSION 3.16)
project(jank_json_sys VERSION 3.12.0)

add_subdirectory(json)
install(DIRECTORY "${CMAKE_CURRENT_LIST_DIR}/json/include/"
        DESTINATION "${CMAKE_INSTALL_INCLUDEDIR}")
