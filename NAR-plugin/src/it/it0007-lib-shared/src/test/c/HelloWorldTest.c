/*
 * #%L
 * Native ARchive plugin for Maven
 * %%
 * Copyright (C) 2002 - 2014 NAR Maven Plugin developers.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
#include <stdio.h>
#include <stdlib.h>
#include "HelloWorldLib.h"

int main(int argc, char *argv[]) {
	printf("%s\n", HelloWorldLib_sayHello());
	if(getenv("TESTENVVAR")) {
	    printf("Found expected test environment variable\n");
	    return 0;
	} else {
	    printf("Did not find expected test environment variable\n");
	    return 1;
    }
}


