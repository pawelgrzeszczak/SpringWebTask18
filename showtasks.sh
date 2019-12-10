#!/usr/bin/env bash

open_site() {
  if open http://localhost:8080/crud/v1/task/getTasks; then
     echo "Successfully open link"
  else
     echo "Cannot open link"
     fail
  fi
}

ok() {
  echo "Running script"
}

fail() {
  echo "There were errors"
}

end() {
  echo "Work is finished"
}

if ./runcrud.sh; then
   ok
   open_site
else
   fail
fi