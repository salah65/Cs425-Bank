package edu.miu.cs.cs425bank.cs425bank.core;

import java.util.List;

public interface Mapper <Domain,Request,Response>{
     Response mapToResponse(Domain domain);
     Domain mapToDomain(Request request);
     List<Response> mapToResponses(List<Domain> domains);
}
