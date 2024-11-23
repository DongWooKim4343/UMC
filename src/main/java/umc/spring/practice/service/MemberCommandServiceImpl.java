//package umc.spring.practice.service;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import umc.spring.apiPayload.code.status.ErrorStatus;
//import umc.spring.apiPayload.exception.handler.FoodCategoryHandler;
//import umc.spring.domain.entity.FoodCategory;
//import umc.spring.domain.repository.FoodCategoryRepository;
//import umc.spring.practice.Member;
//import umc.spring.practice.MemberPrefer;
//import umc.spring.practice.dto.MemberConverter;
//import umc.spring.practice.dto.MemberPreferConverter;
//import umc.spring.practice.dto.MemberRequestDTO;
//import umc.spring.practice.repository.MemberRepository;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class MemberCommandServiceImpl implements MemberCommandService{
//
//    private final MemberRepository memberRepository;
//
//    private final FoodCategoryRepository foodCategoryRepository;
//
//    @Override
//    @Transactional
//    public Member joinMember(MemberRequestDTO.JoinDto request) {
//
//        Member newMember = MemberConverter.toMember(request);
//        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
//                .map(category -> {
//                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
//                }).collect(Collectors.toList());
//
//        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);
//
//        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});
//
//        return memberRepository.save(newMember);
//    }
//
//}