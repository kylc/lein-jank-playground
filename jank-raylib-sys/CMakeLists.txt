cmake_minimum_required(VERSION 3.16)
project(jank_raylib_sys VERSION 6.0)

add_subdirectory(raylib)

include(GNUInstallDirs)
install(TARGETS raylib
    RUNTIME DESTINATION ${CMAKE_INSTALL_BINDIR}
    LIBRARY DESTINATION ${CMAKE_INSTALL_LIBDIR}
    ARCHIVE DESTINATION ${CMAKE_INSTALL_LIBDIR}
)
