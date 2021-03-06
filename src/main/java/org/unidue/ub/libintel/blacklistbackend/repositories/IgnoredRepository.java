package org.unidue.ub.libintel.blacklistbackend.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.unidue.ub.libintel.blacklistbackend.model.Ignored;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "ignored", path = "ignored")
public interface IgnoredRepository  extends PagingAndSortingRepository<Ignored, String> {

    List<Ignored> findAllByTitleId(String titleId);

    List<Ignored> findAllByTitleIdAndAndType(String titleId, String type);

}
