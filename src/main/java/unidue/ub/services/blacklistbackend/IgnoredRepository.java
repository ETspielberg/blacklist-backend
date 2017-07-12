package unidue.ub.services.blacklistbackend;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import unidue.ub.media.analysis.Ignored;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "ignored", path = "ignored")
public interface IgnoredRepository  extends PagingAndSortingRepository<Ignored, Long> {

}
