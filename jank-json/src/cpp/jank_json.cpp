#include "jank_json.hpp"

#include <nlohmann/json.hpp>

namespace jank::json
{
  std::string format(std::string const &input)
  {
    auto data = nlohmann::json::parse(input);
    return data.dump(2);
  }
}
